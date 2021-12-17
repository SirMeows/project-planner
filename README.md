# project-planner

Project name is a project management tool for project managers to breakdown projects to smaller parts and get an overview of tasks in a Gantt Chart


## Contributing to project-planner
To contribute to project-planner, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the original branch: `git push origin project-planner/<location>`
5. Create the pull request.

Alternatively see the GitHub documentation on [creating a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## Contributors

Thanks to the following people who have contributed to this project:

* [@SirMeows](https://github.com/SirMeows) 
* [@psand](https://github.com/psand) 


## Deploy to heroku.com with ClearDB

To deploy project-planner on heroku follow these steps:

1. Fork this repository.
2. Create a account on heroku.com.
3. Create new App on heroku.
4. Add ClearDB as an add-on under resources.
5. DB name, host, username and password can now be derived from CLEARDB_DATABASE_URL environment variable. (settings -> config vars -> reveal config vars)
6. Connect to the database and execute statements in src/main/resources/structure.sql with your favorite MySQL client
7. Add environment variables PP_DB_URL, PP_DB_USERNAME and PP_DB_PASSWORD with the values for ClearDB (settings -> config vars)
8. Choose github as deployment method, allow heroku access.
9. Choose which branch you want to deploy and press "Deploy Branch" (and cross your fingers)


## License

This project uses the MIT License (https://opensource.org/licenses/MIT).