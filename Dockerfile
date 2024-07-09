FROM amazoncorretto:17-alpine3.19

# Set the working directory
WORKDIR /app

# Copy gradle wrapper files
COPY gradlew ./
COPY gradle/ ./gradle/

# Copy the source code
COPY . .

# Expose the default tomcat port
EXPOSE 8080

# Give running permission to the development script
RUN chmod +x development.sh

# Make gradlew executable
RUN chmod +x ./gradlew

# Get gradle dependencies
RUN ./gradlew getDependencies

# Start the development server

CMD ["sh" , "development.sh"]
