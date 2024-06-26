# Download dynamoDB Local zip file
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html#DynamoDBLocal.DownloadingAndRunning.title

# run local instance of dynamoDb: (use command prompt to navigate to zip file then run the code)
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

# using another terminal tab, run aws configure
aws configure
-fakeMyKeyId
-fakeSecretAccessKey
-fakeRegion
-json

# test if you can access DynamoDB:
aws dynamodb list-tables --endpoint-url http://localhost:8000

# Create a table with CLI:
aws dynamodb create-table --table-name ProductInfo --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://localhost:8000

# Now the spring application should be able to connect to the dynamoDb instance


Notes:
We must use spring 2.1 and java 11 since these are the only versions compatible with spring-data-dynamodb

spring-data-dynamodb is needed to use abstraction for repositories