# Replace with your own API credentials
$username = 'your_username'
$password = 'your_password'
$headers = @{ Authorization = 'Basic ' + [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes("$($username):$($password)")) }

# Replace with the path to the file you want to upload
$file_path = 'C:\path\to\your\file.ext'

# Authenticate and get an upload link
$auth_response = Invoke-RestMethod -Uri 'https://api.pcloud.com/userinfo' -Method Post -Headers $headers
$upload_link = $auth_response.hosts[0] + '/uploadlink'

# Upload the file
$file_data = Get-Content $file_path -Encoding Byte
$upload_response = Invoke-RestMethod -Uri $upload_link -Method Post -ContentType 'application/octet-stream' -Body $file_data
if ($upload_response.result -eq 0) {
    Write-Host 'File uploaded successfully!'
} else {
    Write-Host 'Upload failed. Error message: ' $upload_response.error
}
