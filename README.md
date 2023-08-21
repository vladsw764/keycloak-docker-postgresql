# Project Name: Secure Spring Boot REST API with Keycloak and OAuth 2.0

## Description

This project demonstrates how to secure a Spring Boot REST API using Keycloak as an identity and access management solution, along with OAuth 2.0 for authorization. The project showcases various security configurations, including role-based access control, OAuth 2.0 authorization code flow, and JWT token validation.
Spring app with Keycloak and Docker

## Security implementation

### Keycloak Integration
The project integrates with Keycloak, which serves as the Identity Provider (IdP) for authentication and authorization. Keycloak manages user identities, roles, and provides tokens for secure access to resources.

### JWT Token Validation
JWT tokens issued by Keycloak are validated and converted to authentication tokens using the `JwtAuthenticationConverter` class. This class implements the `Converter<Jwt, AbstractAuthenticationToken>` interface to extract roles from the token and create authentication tokens with appropriate authorities.

### Role-Based Access Control
The OrderController class demonstrates role-based access control using Spring Security's @PreAuthorize annotations. The `@PreAuthorize("hasRole('ADMIN')")` annotation restricts access to the `/api/orders/{category}` endpoint to users with the `'ADMIN'` role, while the `@PreAuthorize("hasAnyRole('ADMIN', 'USER')")` annotation allows access to the `/api/profile-image` endpoint for both `'ADMIN'` and `'USER'` roles.

## OAuth 2.0 Authorization Code Flow

The application is configured as an OAuth 2.0 resource server. The `application.yml` file includes settings for the Keycloak OAuth 2.0 client. The authorization code flow is used for user authentication and authorization. This flow provides enhanced security as it involves multiple steps, including user consent and token exchange.

## Usage in Real Applications

The provided code demonstrates a solid foundation for securing Spring Boot applications using Keycloak and OAuth 2.0. The architecture allows for secure authentication and authorization of users, role-based access control, and secure resource access. The OAuth 2.0 authorization code flow is a recommended approach for securing real-world applications where strong security measures are required.

## Disclaimer

This project is intended for educational purposes and as a starting point for implementing security features in Spring Boot applications. Actual implementations should consider specific security requirements and potential vulnerabilities that might arise in real-world scenarios. Always keep your software dependencies up to date and follow industry-standard security practices.

## Contact

For any inquiries or questions regarding this project, please feel free to contact me at vladsw764@icloud.com.
