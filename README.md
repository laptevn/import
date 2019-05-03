# Import CSV
This project uses Spring Batch to import records from CSV file and then queries for a sample record.<br>
There is no test since only one line can be covered with unit test. I didn't add integration testing having simplicity of a task in mind.
## How to run?
1. Be sure you have Docker engine running.
2. Run `run.sh` script.
## How to configure application?
If you use Docker Compose file, then just update environment variables there.<br>
If you want to run JAR yourself, then just pass new environment variables while running JAR.
