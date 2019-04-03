#!/usr/bin/env groovy
pipeline {
   agent any
   tools {
        maven 'M3'
   }


   stages {

      // skip a stage while creating the pipeline
      stage("Code Change") {
         steps {
            echo 'This step will never be run'
         }
      }

      stage ('Initialize') {
         steps {
              sh '''
                  echo "PATH = ${PATH}"
                  echo "M2_HOME = ${M2_HOME}"
              '''
         }
      }

      stage("Build") {
         steps {
            sh "server/mvn clean install"
         }
      }

      stage('Automation Test') {
         steps {
            echo 'WHEN with AND expression works!'
         }
      }

      stage('Deploy') {
         steps {
            echo 'WHEN with OR expression works!'
         }
      }

   }
}