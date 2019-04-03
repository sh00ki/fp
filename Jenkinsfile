#!/usr/bin/env groovy
pipeline {
    agent any
    tools {
            maven 'M3'
    }
    environment {
        MAVEN_HOME = '/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/M3'
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
                    rtMaven.tool = MAVEN_HOME // Tool name from Jenkins configuration
                    rtMaven.opts = "-Denv=dev"
                    rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server
                    rtMaven.resolver releaseRepo:'libs-release', snapshotRepo:'libs-snapshot', server: server

                    rtMaven.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildInfo

                    buildInfo.retention maxBuilds: 10, maxDays: 7, deleteBuildArtifacts: true
                    // Publish build info.
                    server.publishBuildInfo buildInfo
                }
            }
        }

   }
}