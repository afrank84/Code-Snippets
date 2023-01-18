$uri = "http://192.168.1.2/api/your-api-key/lights/1/state"
$json = @{on = $true} | ConvertTo-Json
$request = [System.Net.WebRequest]::Create($uri)
$request.Method = "PUT"
$request.ContentType = "application/json"
$request.GetRequestStream() | Out-Null
$request.GetRequestStream().Write($json, 0, $json.length)
$request.GetResponse()
