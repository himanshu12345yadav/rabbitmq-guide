FROM eclipse-temurin:latest

# Set the working directory
WORKDIR /app

# Copy the source code
COPY . .

# Expose the default tomcat port
EXPOSE 8080

# Give running permission to the development script
RUN chmod +x development.sh && ./gradlew getDependencies

# Start the development server

CMD ["sh" , "development.sh"]
