# Spring To Do project

## Requirements 

### Project has to utilize following technologies:

   - spring boot 3.1
   - spring boot data jpa
   - spring boot mvc
   - spring boot thymeleaf
   - spring framework security
   - database (h2/postgresql/mysql)
   - liquibase
   - webjars
   - bootstrap 5
   - git

### Optional technologies
   - docker 
   - docker-compose
   - spring boot docker compose support

### Expected features

   - Application loads initial database schema and data using liquibase
   - Application allows access only to authorized users
   - Application has to support two roles: admin, user
   - Only admins can create new users using form
   - Application allows user to list his own tasks / task categories / tasks statuses
   - Application allows user to create his own tasks / task categories / tasks statuses 
   - Application allows user to update his own tasks / task categories / tasks statuses 
   - Application allows user to delete his own tasks
   - Task consist of:
     
     - summary (nullable=false)
     - description
     - owner
     - start date
     - end date
     - attachment (optional feature)
     - task category
     - task status

   - Task status consist of:

     - name
     - display name
     - owner

   - Task category consists of:
   
     - name
     - description
     - image (optional feature)

### Optional features

   - Deleting or disabling task categories, statuses, users 
