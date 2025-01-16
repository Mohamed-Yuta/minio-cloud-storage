
# MinIO File Manager with Spring Boot and JSP

## Introduction
This project is a **Spring Boot application** integrated with **MinIO**, designed to manage file uploads and retrievals using a simple web interface built with JSP (JavaServer Pages). The application demonstrates the integration of MinIO as a storage backend for managing objects while providing an intuitive frontend for user interaction.

## Features
- Upload files to a MinIO bucket.
- List all files stored in the MinIO bucket.
- View metadata such as file size, upload date, and URL.
- Simple and intuitive JSP-based frontend.

## Technologies Used
- **Spring Boot 3.2.1**
- **MinIO (Java SDK)**
- **JSP (JavaServer Pages)**
- **Lombok** for cleaner code
- **Maven** for dependency management
- **Embedded Tomcat** for running the application

## Prerequisites
1. Java Development Kit (JDK) 17 or higher.
2. Maven installed.
3. A running instance of MinIO server.
4. IntelliJ IDEA or any Java IDE (optional).

## Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/your-repo-name/minio-file-manager.git
cd minio-file-manager
```

### 2. Configure `application.properties`
Update the `src/main/resources/application.properties` file with your MinIO configuration:

```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

minio.endpoint=http://localhost:9000
minio.accessKey=minioadmin
minio.secretKey=minioadmin
minio.bucket=pdfs

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

### 3. Start MinIO Server
If MinIO is not already running, you can start it using Docker:

```bash
docker run -p 9000:9000 -p 9001:9001 --name minio \
  -e "MINIO_ROOT_USER=minioadmin" \
  -e "MINIO_ROOT_PASSWORD=minioadmin" \
  quay.io/minio/minio server /data --console-address ":9001"
```

### 4. Build and Run the Application
Use Maven to build and run the project:

```bash
mvn clean install
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Using the Application

### 1. Upload a File
1. Navigate to `http://localhost:8080`.
2. Select a file using the upload form.
3. Click the **Upload** button.
4. A success message will confirm the upload, and the file will appear in the list.

### 2. View Uploaded Files
The homepage lists all files currently stored in the MinIO bucket. For each file, the following details are displayed:
- **File Name**
- **Upload Date**
- **File Size**
- **Download URL** (clickable link)

### Example Screenshot
*(Add screenshots of the web interface here)*

## Project Structure
```
minio-file-manager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.minio/
│   │   │   │   ├── config/          # MinIO configuration
│   │   │   │   ├── controller/      # Controllers handling HTTP requests
│   │   │   │   ├── dto/             # Data Transfer Objects
│   │   │   │   ├── service/         # MinIO interaction logic
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── templates/
│   │   │   │   ├── jsp/             # JSP views
│   ├── test/                        # Unit and integration tests
```

## Troubleshooting
### Common Issues
1. **Cannot connect to MinIO**: Ensure MinIO is running and the credentials in `application.properties` are correct.
2. **File not uploading**: Check that the file size does not exceed the configured limits in `application.properties`.
3. **Error 404 for JSP pages**: Verify that JSP files are placed in `src/main/webapp/WEB-INF/jsp/` and that `spring.mvc.view.prefix` is set correctly.

### Logs
Check the application logs for detailed error messages:
```bash
tail -f logs/spring.log
```

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

---

Enjoy managing your files with **MinIO File Manager**! 🚀
