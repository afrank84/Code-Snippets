import com.atlassian.confluence.pages.PageManager
import com.atlassian.confluence.pages.Page
import com.atlassian.confluence.spaces.SpaceManager
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal
import java.util.Calendar

def pageManager = ComponentAccessor.getPageManager()
def spaceManager = ComponentAccessor.getSpaceManager()
def user = AuthenticatedUserThreadLocal.get()

def spaceKey = "SPACEKEY"
def pageTitle = "New Page Title"
def pageContent = "New Page Content"

def space = spaceManager.getSpace(spaceKey)
def parentPage = space.homePage

def cal = Calendar.getInstance()
def weekdays = [Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY]

if (weekdays.contains(cal.get(Calendar.DAY_OF_WEEK))) {
    def newPage = new Page()
    newPage.setTitle(pageTitle)
    newPage.setContent(pageContent)
    newPage.setSpace(space)
    newPage.setParentPage(parentPage)

    // If you have a template, you can set it using the following line
    // newPage.setTemplate("My Template")

    pageManager.saveContentEntity(newPage, null)
}
/*
This script uses the Calendar class to determine the current day of the week, and checks if it's a weekday 
(Monday through Friday) using the weekdays list.

If the current day is a weekday, the script creates a new page with the specified title, content, space, 
and parent page, and saves it using the pageManager.saveContentEntity() method.

To use a template for the new page, you can set the template name using the newPage.setTemplate("My Template") line, 
where "My Template" is the name of your template.

You can customize the pageTitle and pageContent variables to use dynamic values, or read them from an external 
source (e.g. a CSV file or database) to create pages with different titles and content.

*/



