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

        stage("Build") {
            steps {
                withMaven(maven: 'M3') {
                        sh "mvn clean install"
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
                script {
                    def server = Artifactory.server "Artifactory"
                    def buildInfo = Artifactory.newBuildInfo()
                    buildInfo.env.capture = true
                    def rtMaven = Artifactory.newMavenBuild()
                    rtMaven.opts = "-Denv=dev"

                    rtMaven.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildInfo

                    // Publish build info.
                    server.publishBuildInfo buildInfo
                }
            }
        }

   }
}