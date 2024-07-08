# Project EasyInvoice
## EasyInvoice Customer (customer)
### Description:
The 'customer' microservice manages all customer-related operations. It handles the creation, retrieval, updating, and deletion of customer information. This service communicates with the 'invoice' microservice to provide customer data required for invoice processing.

### Key Features:
- RESTful APIs for customer management.
- Inter-service communication with invoice service using WebClient.
- Integration with invoice-core for entity definitions.

## Integration Overview
EasyInvoice is designed as a microservices architecture where each service has a distinct responsibility. The invoice-core module provides the shared entity definitions, while the customer, invoice, and product services handle their respective domains. The service-discovery module facilitates dynamic discovery and communication among these services.
- Customer Service: Provides customer data to the Invoice service. https://github.com/MathEyraud/EasyInvoice-Customer
- Invoice Service: Manages invoices and retrieves necessary customer and product data from respective services. https://github.com/MathEyraud/EasyInvoice-Invoice
- Product Service: Supplies product information to the Invoice service. https://github.com/MathEyraud/EasyInvoice-Product
- Service Discovery: Ensures all services can discover and communicate with each other. https://github.com/MathEyraud/EasyInvoice-ServiceDiscovery
- Invoice Core: https://github.com/MathEyraud/Java-Learn-Spring-Data-Core/tree/Microservices
This architecture ensures scalability, modularity, and ease of maintenance, making EasyInvoice a robust and flexible invoicing solution.

## EasyInvoice Core (core)
### Description:
The 'invoice-core' module contains the core entity definitions and handles communication with the database. This module is the foundation of the EasyInvoice system, providing the necessary entity classes that are used across different microservices.
https://github.com/MathEyraud/Java-Learn-Spring-Data-Core/tree/Microservices

### Entities:
- Customer
- Address
- Invoice
- InvoiceLine
- Product
- Category
