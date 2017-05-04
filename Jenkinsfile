node {
  
   def maven35 = docker.image('jayv/jenkins-java');
         
   stage 'Spin up build container'

   maven35.inside() {

   stage 'GIT'

   checkout scm

   stage 'Run build job'
   	
   	 withCredentials(
                [
                    [$class: 'StringBinding', credentialsId: 'M2_PWD', variable: 'M2_PWD']
                ]) {
 
			sh 'mvn -B -s jenkins-settings.xml clean install'

        }

   }
  
}
