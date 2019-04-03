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

      stage("Build") {
         steps {
            withMaven(
                    maven: 'M3',
                    mavenSettingsConfig: 'my-maven-settings',
                    mavenLocalRepo: '.repository') {

                  sh "server/mvn clean install"

                }
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