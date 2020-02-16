Restfull web service: OAuth2 + JWT using Spring Boot 2 / Spring Security 5
---


How to Test Rest API

First you to mke up and running both application spring-boot-resource-server and spring-boot-authorization-server.

You need to creat a json file then copy below josn data into newly created file.
Open the postman and click on  import and select json file. It will import all required enpoint as well as request parament like header, body etc to test all enpoints.

{
	"info": {
		"_postman_id": "fcc696af-510b-4d32-b9eb-5a6caed51d6e",
		"name": "Springboot-Rest-JWT-Oauht2",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "localhost:8080/oauth/token",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "secret",
							"type": "string"
						},
						{
							"key": "username",
							"value": "clientId",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/x-www-form-urlencoded",
						"type": "text"
					}
				],
				"body": {
					"mode": "urlencoded",
					"urlencoded": [
						{
							"key": "grant_type",
							"value": "password",
							"type": "text"
						},
						{
							"key": "username",
							"value": "user",
							"type": "text"
						},
						{
							"key": "password",
							"value": "pass",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "localhost:8080/oauth/token",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"oauth",
						"token"
					]
				},
				"description": "Get access token and refresh token"
			},
			"response": []
		},
		{
			"name": "http://localhost:9090/employees/",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODE4Mzg3MzUsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiZDg4NDQ4N2UtMWI1My00NDAzLThmZjYtNzY4NTViYTUyYzc0IiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.WK9-bnTfHMPpkrC4DdAzPi8EL3I9jjKauUveSbaffxHP338fk7aejccfhou_hvGiXUWCYiSEpWb3_mugTa-NV_NQf3D1QHmaHDol9T1d56EzJYEtHPVtkeRYWvFvMIlpNX-RJYtxMdl9IAaNdfxGcxlrZwn70kC3w_Guq2a1I0XclIVePZoJJBHbFKzVodF0SLaK3gNcpax56a7JOVY1ryowui0xHv5bYk4YqJnAYG7H_il9T8xDlGdBtiO2_Ssy05Y6TqoMDaHwNPIR83DqWFK0q6RCztjMA9A9fn71vnTGKFMrzZF4nVezxAEXPf8ZaqdoKt-nPu0ZvTlh1T0AKQ",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:9090/employees/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "9090",
					"path": [
						"employees",
						""
					]
				},
				"description": "Get All employee"
			},
			"response": []
		},
		{
			"name": "http://localhost:9090/employees/",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODE4Mzg3MzUsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiZDg4NDQ4N2UtMWI1My00NDAzLThmZjYtNzY4NTViYTUyYzc0IiwiY2xpZW50X2lkIjoiY2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.WK9-bnTfHMPpkrC4DdAzPi8EL3I9jjKauUveSbaffxHP338fk7aejccfhou_hvGiXUWCYiSEpWb3_mugTa-NV_NQf3D1QHmaHDol9T1d56EzJYEtHPVtkeRYWvFvMIlpNX-RJYtxMdl9IAaNdfxGcxlrZwn70kC3w_Guq2a1I0XclIVePZoJJBHbFKzVodF0SLaK3gNcpax56a7JOVY1ryowui0xHv5bYk4YqJnAYG7H_il9T8xDlGdBtiO2_Ssy05Y6TqoMDaHwNPIR83DqWFK0q6RCztjMA9A9fn71vnTGKFMrzZF4nVezxAEXPf8ZaqdoKt-nPu0ZvTlh1T0AKQ",
						"type": "text"
					},
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"id\": 4,\r\n    \"firstName\": \"Raj\",\r\n    \"lastName\": \"Brij\",\r\n    \"email\": \"ram@gmail.com\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:9090/employees/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "9090",
					"path": [
						"employees",
						""
					]
				},
				"description": "Post Employee"
			},
			"response": []
		},
		{
			"name": "localhost:8080/oauth/token",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "secret",
							"type": "string"
						},
						{
							"key": "username",
							"value": "clientId",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/x-www-form-urlencoded",
						"type": "text"
					}
				],
				"body": {
					"mode": "urlencoded",
					"urlencoded": [
						{
							"key": "grant_type",
							"value": "refresh_token",
							"type": "text"
						},
						{
							"key": "refresh_token",
							"value": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6IjAxNmU2OGU5LTRhMzMtNGJlOC1hMzE1LTU3MjdiOTYzNWM4MyIsImV4cCI6MTU4NDQzMTI0MCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjA4MzQ3MjFiLTM2YzItNGQwMi1hZjExLTdiNjc5M2IwN2M1MyIsImNsaWVudF9pZCI6ImNsaWVudElkIn0.U3Uv9oAzKqOazlGKQoFnK65bogSZOps8E5iukRLYi30np81Ya8p8ieJhgoGmKJIUgyg_2KKww93AJO3OitCRC5c1Nxgs4373W_HeyMhvK7rYg9gbUEvL9kSoAVVTNaYXvy8BBnTEyzFM8KAPw1DxcXDRfm0g6xYm8r7f-jSX5VJfluY3hM3ZpyJ1vOY_V_sioJvZsdaRu3pUgqX63tjAI-2ht_cK7pfiVYJ_mzhrJMS0UwfvEjghP8K8u7vKZS4M3GDD39kKGwTICmO8F3XJsUw8GPJR91HNrE3q2vkvujuVSptQdHs8axtJnqBHK3CHkmUD98extaGb7D4lH73T5w",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "localhost:8080/oauth/token",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"oauth",
						"token"
					]
				},
				"description": "Get refresh token"
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}
