# Install the HueSharp module
Install-Module -Name HueSharp

# Create a new HueClient
$client = New-Object HueSharp.HueClient -ArgumentList "192.168.1.2"

# Authenticate with the bridge
$client.Initialize("your-api-key")

# Get all lights
$lights = $client.GetLights()

# Turn on the first light
$client.SetLightState($lights[0].Id, [HueSharp.HueSharp.LightState]::On())
