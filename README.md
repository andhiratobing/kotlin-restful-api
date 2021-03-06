## Belajar RESTful API dari [Eko Kurniawan Khannedy](https://github.com/ProgrammerZamanNow)

## Database : postgresql


## Authentication
All API must use this authentication
Request :

- Header:
  - X-API-Key: "API Key"

#Authorization:
- API Key = "X-API-Key"
- Value = "SECRET"
  
  

## API SPECIFICATION

## CREATE PRODUCT
Request:
- Method : POST
- Endpoint : `api/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json
-Body :
```json
{
  "id": "String, Unique",
  "name": "String",
  "price": "Long",
  "quantity": "Int"
}
```
Response :
```json
  {
    "code": "Number",
    "status": "String",
    "data": {
        "id": "String, Unique",
        "name": "String",
        "price": "Long",
        "quantity": "Int",
        "createdAt": "Date",
        "updatedAt": "Date"
}
}
```

## GET PRODUCT
- Method : GET
- Endpoint : `api/products/{id_product}`
- Header :
  - Accept: application/json

Response :
```json
    {
  "code": "Number",
  "status": "String",
  "data": {
        "id": "String, Unique",
        "name": "String",
        "price": "Long",
        "quantity": "Int",
        "createdAt": "Date",
        "updatedAt": "Date"
      }
}
```


## UPDATE PRODUCT
Request:
- Method : PUT/PATCH
- Endpoint : `api/products/{id_product}`
- Header :
  - Content-Type: application/json
  - Accept: application/json
  - Body :
```json
{
  "name": "String",
  "price": "Long",
  "quantity": "Int"
}
```
Response :
```json
    {
  "code": "Number",
  "status": "String",
  "data": {
    "id": "String, Unique",
    "name": "String",
    "price": "Long",
    "quantity": "Int",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```

## LIST PRODUCT
Request:
- Method : GET
- Endpoint : `api/products`
- Header :
  - Accept: application/json
  
- Query Param :
  - size : number,
  - page : number
  

Response :
```json
    {
  "code": "Number",
  "status": "String",
  "data": [
    {
      "id": "String, Unique",
      "name": "String",
      "price": "Long",
      "quantity": "Int",
      "createdAt": "Date",
      "updatedAt": "Date"
    },{
      "id": "String, Unique",
      "name": "String",
      "price": "Long",
      "quantity": "Int",
      "createdAt" : "Date",
      "updatedAt" : "Date"
     } 
    ]
}

```



## DELETE PRODUCT
Request:
- Method : DELETE
- Endpoint : `api/products/{id_product}`
- Header :
  - Accept: application/json

Response :
```json
    {
  "code": "Number",
  "status": "String"
}
```
