import com.atlassian.jira.component.ComponentAccessor
/*
This script uses the ComponentAccessor to get access to Jira's UserManager and IssueService, 
which are then used to retrieve an issue by its key, change its assignee, and update it. 
This script could be used, for example, as a post-function in a workflow transition to automatically 
assign an issue to a specific user.
*/

def userManager = ComponentAccessor.getUserManager()
def issueService = ComponentAccessor.getIssueService()

def user = userManager.getUserByName("username")
def issue = issueService.getIssue(user, "ISSUE-123").issue

// Change the assignee of the issue
issue.setAssignee(user)

// Update the issue
def updateValidationResult = issueService.validateUpdate(user, issue.id, issue)
if (updateValidationResult.isValid()) {
    issueService.update(user, updateValidationResult)
} else {
    log.warn("Failed to update issue ${issue.key}: ${updateValidationResult.errorCollection}")
}
