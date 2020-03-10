# SPS2PLC

[![Latest Version](https://img.shields.io/badge/build-passing-green)]()
[![The MIT License](http://img.shields.io/badge/license-MIT-blue.svg)]()
   
SPS2PLC (Specification Pattern System to Programmable Logic Controller) is a tool that helpes developing requirements and generating PLC code from formalized specification .

The specification of requirements is a critical activity in software and system development. A defect in a requirement specification can result in a situation where a software or system is delivered that fullfills the given requirements, but does not satisfy the customer's needs due to erroneous requirments.

To make it possible for a computer to check a set of requirements for a given criteria, it has to "understand" the semantics of the requirements. This could be achieved by using formal languages, which usually share the fact that they are rarely understandable for humans.

In this method we developed a simple pattern language named a SPS based on Property Specification Patterns defined in [1][2]. The language is based on a restricted English grammar and hence looks like natural language. Requirements formalized in this specification language can automatically be translated into logics (such as temporal logics).

Programmable Logic Controller (PLC) is a kind of reactive systems widely used in the field of industrial control. At present, practioners mainly write PLC programs based on personal experience which makes it difficult to avoid requirement and code error. To solve this problem, we designed and implemented SPS2PLC, a tool for PLC code generation, which is able to generate PLC intruction list code based SPS specificaiton, eliminate conflicts in the process of generation, and provide guidance for speicification formalizing.

## Architecture
![未命名文件](https://user-images.githubusercontent.com/8842890/76291428-0b50c980-62e8-11ea-9989-f133223b0680.png)

The architecture of SPS2PLC is outlined above. SPS2PLC can be accessed by multiple users through the internet. It is comprised of the following components:

- The Front-end: The front-end is a web application implemented in Typescript, using the Angular framework, which provides a graphical user interface for the user and performs asynchronous calls to the back-end.
- The Back-end is a Java server application based on the Springboot framework and MySQL database engine. It provides a set of endpoints REST APIs with JSON format for data exchange. In order to access services and user's own data, SPS2PLC employ the JWT open standard for authentication over HTTP.
- Requirement Checker contains algorithms to check consistency and to find a minimal unsatisfiable core of requirements, employing on Z3 Prover (The requiremtns checker is still under development).
- Code Generator contains a parser for SPS language and to generate IL code for PLC program.
- a database to store requirements, user data and other information suck as tasks execution logs.

## Screenshot
![sps2plc online_projects(iPad Pro)](https://user-images.githubusercontent.com/8842890/76288207-2966fb80-62e1-11ea-8592-f09014d0e612.png)
![sps2plc online_projects(iPad Pro) (1)](https://user-images.githubusercontent.com/8842890/76288209-2b30bf00-62e1-11ea-942a-0d52c51d21b7.png)
![sps2plc online_projects(iPad Pro) (2)](https://user-images.githubusercontent.com/8842890/76288212-2c61ec00-62e1-11ea-9728-60f3271709b3.png)
![sps2plc online_(iPad Pro)](https://user-images.githubusercontent.com/8842890/76288216-2d931900-62e1-11ea-91e2-690aeff63c6a.png)

## Installation


### Clone the repo


```
$ git clone git@github.com:PythonYXY/sps2plc-backend.git
```

### Enter the directory

```
$ cd sps2plc-backend
```

### Import database

Create a database named `sps2plc` in MySQL.
```
$ mysql -u root -p sps2plc < ./dump.txt
```

### Run with Java

Only support Java 12+ temporarily.
```
$ java -jar ./target/sps2plc-backend-0.0.1-SNAPSHOT.jar
```

### Play

```
visit http://localhost:8080
```

## Usage

### Online
```
1. Visit http://sps2plc.online

2. Login with test account username: "test", password: "test".
```

### Local
```
Visit http://localhost:8080

1. Login with username: "test", password: "test".

2. Create a new project or select an existing one, selecting a project displays in a table the list of requirements.

3. The user can add, edit (double-click a requirement), delete or disable a requiremnt.

4. To insert new requirements, the user can either upload a text file containsing a list of requirements or use the user interface to help build correct SPSs. The interface allows to select a scope, a pattern and a time-dependent delay, and displaying some text firlds to complete the pattern.

5. Moving to the task tab the user can simply press a button and launch a code generation task on the server. The task will run in background and the interface will update automatically once the task is completed. In case of conlicting requirements, the user needs to provide priority for each conflicting requirements, the larger the number given, the higher the priority.

```
## Frontend

The source code of the frontend can be found in [SPS2PLC-Frontend](https://github.com/PythonYXY/sps2plc-frontend), which is powered by Angular.


## TODO
- [x] User Authentication using JWT
- [ ] Generate ST code for PLC program
- [ ] Integrate SPSChecker into SPS2PLC


## Authors

[PythonYXY](https://github.com/PythonYXY)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## References

[1] Dwyer, M.B., Avrunin, G.S., Corbett, J.C.: Patterns in property specifications for finite-state verification. In: Software Engineering, 1999. Proceedings of the 1999 International Conference on, pp. 411–420. IEEE (1999)

[2] http://ps-patterns.wikidot.com/