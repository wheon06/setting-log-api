pipeline {
	agent any

	stages {
		stage('Checkout') {
			steps {
				git url: 'https://github.com/wheon06/setting-log-api.git', branch: 'main'
            }
		}

        stage('Test') {
            steps {
                sh './gradlew clean test'
            }
        }

		stage('Build And Deploy') {
			stages {
			    stage('Build') {
			        steps {
                        sh '''
                            mkdir -p build/generated-snippets
                            docker build -t setting-log-api:latest .
                        '''
                    }
			    }

			    stage('Deploy') {
			        steps {
			            withCredentials([
                            string(credentialsId: 'DB_HOST', variable: 'DB_HOST'),
                            string(credentialsId: 'DB_PORT', variable: 'DB_PORT'),
                            string(credentialsId: 'DB_PASSWORD', variable: 'DB_PASSWORD'),
                            string(credentialsId: 'DB_NAME', variable: 'DB_NAME'),
			            ]) {
			                sh '''
			                docker rm -f setting-log-api || true

			                docker run -d \
			                --restart=always \
			                --name setting-log-api \
			                -p 9595:8080 \
			                -e TZ=Asia/Seoul \
			                -e DB_HOST=$DB_HOST \
                            -e DB_PORT=$DB_PORT \
                            -e DB_PASSWORD=$DB_PASSWORD \
                            -e DB_NAME=$DB_NAME \
                            -e SPRING_PROFILES_ACTIVE=prod \
                            setting-log-api:latest
			                '''
			            }
			        }
			    }
			}
		}
	}
}
