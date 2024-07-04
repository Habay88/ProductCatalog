Product Catalog Service
This is a Spring Boot application for managing a product catalog for an e-commerce platform. The service allows for CRUD operations on products and categories, with support for searching and filtering.

Requirements
Java 17
Maven 3.8.1+
A relational database (MySQL)

1.   Clone the Repository

git  clone https://github.com/Habay88/ProductCatalog.git
cd ProductCatalog

2 . Configure the Database
Update the application.properties file located in src/main/resources with your database configuration.

For example, for a MySQL database:
spring.datasource.username= yourusername
spring.datasource.password=yourpassword

3. Build the Project
mvn clean install

4. Run the Application
mvn spring-boot:run

The application will start and be accessible at http://localhost:8083.
OR 

IT CAN BE ACCESSED THROUGH : http://localhost:8083/swagger-ui/index.html   USING THE OPENAPI CONFIGURATION

API Documentation

Endpoints
Categories

Create Category

URL: /api/categories/save

Method: POST

Request Body:

json
Copy code
{
    "name": "Cuttleries"
}
Response:

json
Copy code
{
    "id": 1,
    "name": "Cuttleries"
}
Get All Categories

URL: /api/categories

Method: GET

Response:

json
Copy code
[
    {
        "id": 1,
        "name": "Cuttleries"
    }
]
Get Category by ID

URL: /api/categories/{id}

Method: GET

Response:

json
Copy code
{
    "id": 1,
    "name": "Cuttleries"
}
Update Category

URL: /api/categories/{id}

Method: PUT

Request Body:

json
Copy code
{
    "name": "Kitchen  Ware"
}
Response:

json
Copy code
{
    "id": 1,
    "name": "Kitchen  Ware"
}
Delete Category

URL: /api/categories/{id}
Method: DELETE
Response: 204 No Content
Products
Create Product

URL: /api/products/save

Method: POST

Request Body:

json
Copy code
{
    "name": "Smartphone",
    "price": 699.99,
    "category": {
        "id": 1
    }
}
Response:

json
Copy code
{
    "id": 1,
    "name": "Smartphone",
    "price": 699.99,
    "category": {
        "id": 1,
        "name": "Electronics"
    }
}
Get All Products

URL: /api/products

Method: GET

Response:

json
Copy code
{
    "content": [
        {
            "id": 1,
            "name": "Smartphone",
            "price": 699.99,
            "category": {
                "id": 1,
                "name": "Electronics"
            }
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
Get Product by ID

URL: /api/products/{id}

Method: GET

Response:

json
Copy code
{
    "id": 1,
    "name": "Smartphone",
    "price": 699.99,
    "category": {
        "id": 1,
        "name": "Electronics"
    }
}
Update Product

URL: /api/products/{id}

Method: PUT

Request Body:

json
Copy code
{
    "name": "Smartphone X",
    "price": 799.99,
    "category": {
        "id": 1
    }
}
Response:

json
Copy code
{
    "id": 1,
    "name": "Smartphone X",
    "price": 799.99,
    "category": {
        "id": 1,
        "name": "Electronics"
    }
}
Delete Product

URL: /api/products/{id}
Method: DELETE
Response: 204 No Content
Get Products by Category

URL: /api/products/category/{categoryId}

Method: GET

Response:

json
Copy code
{
    "content": [
        {
            "id": 1,
            "name": "Smartphone",
            "price": 699.99,
            "category": {
                "id": 1,
                "name": "Electronics"
            }
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
Get Products by Price Range

URL: /api/products/price-range

Method: GET

Request Parameters:

minPrice: Minimum price
maxPrice: Maximum price
Response:

json
Copy code
{
    "content": [
        {
            "id": 1,
            "name": "Smartphone",
            "price": 699.99,
            "category": {
                "id": 1,
                "name": "Electronics"
            }
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
Search Products by Name

URL: /api/products/search

Method: GET

Request Parameters:

name: Name of the product
Response:

json
Copy code
{
    "content": [
        {
            "id": 1,
            "name": "Smartphone",
            "price": 699.99,
            "category": {
                "id": 1,
                "name": "Electronics"
            }
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "first": true,
   









