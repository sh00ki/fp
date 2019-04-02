#!/usr/bin/env groovy
pipeline {
   agent any


   stages {

      // skip a stage while creating the pipeline
      stage("Code Change") {
         steps {
            echo 'This step will never be run'
         }
      }

      // Execute when branch = 'master'
      stage("Build") {
         steps {
            echo 'BASIC WHEN - Master Branch!'
         }
      }

      // Expression based when example with AND
      stage('Automation Test') {
         steps {
            echo 'WHEN with AND expression works!'
         }
      }

      // Expression based when example
      stage('Deploy') {
         steps {
            echo 'WHEN with OR expression works!'
         }
      }

   }
}