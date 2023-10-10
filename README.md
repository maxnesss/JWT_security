## Spring Boot 3 + JPA + Auth JWT

### Description
Spring security with jwt token in http only cookie
with use of PreAuthorize annotation


### Need to change
 1. Application properties - to set up database
 2. Constants
- use env variables or somthing similar
### Registration
- /api/v1/auth/register
- RegisterUserDTO
### Login
- /api/v1/auth/authenticate
- AuthenticationRequestDTO 
### Roles
- String
  - ROLE_ADMIN
  - ROLE_USER
### Endpoints
- public
  - /api/v1/public/
- users
  - /api/v1/users/
- admin
  - /api/v1/users/
- note: need to use the @PreAuthorize annotation