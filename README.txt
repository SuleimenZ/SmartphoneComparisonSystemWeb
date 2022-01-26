For this project you have to have Postgre database created. You need to configure database connection details in hibernate.cfg.xml file. If you do this, remember to repackage the project, because run.bat uses jar to run.
You might also use this parameters when creating database:
user: postgres
password: pwd123
database name: ComparisonSystemDB
jdbc connection url: jdbc:postgresql://localhost:5432/ComparisonSystemDB

I've also implemented API for this project. They are available under these links (ip:port may vary):
localhost:8080/api/v1/smartphone
localhost:8080/api/v1/brand
localhost:8080/api/v1/os
localhost:8080/api/v1/chipset

All data used for filling database are stored inside config.java files (BrandConfig.java, OSConfig.java, etc.)

To run application execute commands in CompileInfo.txt or run Run.bat
(windows only, I'm not that familiar with linux)