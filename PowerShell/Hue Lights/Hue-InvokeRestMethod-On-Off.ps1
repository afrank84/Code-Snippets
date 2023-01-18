$uri = "http://192.168.1.2/api/your-api-key/lights/1/state"
$body = @{on = $true}
Invoke-RestMethod -Method Put -Uri $uri -Body (ConvertTo-Json $body)
