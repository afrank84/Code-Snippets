#Option 1
Get-ChildItem "C:\Folder_Name_Here" | Measure-Object -Property Length -sum

#Option2
#To convert the size into a more convenient MB or GB, use this command:
(gci "C:\Folder_Name_Here" | measure Length -s).sum / 1Gb
#or
(gci "C:\Folder_Name_Here" | measure Length -s).sum / 1Mb

#Option 3
<# 
You can use PowerShell to calculate the total size of all files of a certain type in a directory. 
For example, you want to get the total size of all ISO files in a folder:
#>
(gci c:\iso *.iso | measure Length -s).sum / 1Mb