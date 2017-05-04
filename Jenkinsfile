node {
  
   def maven35 = docker.image('jayv/jenkins-java');
   
   stage 'Pull build image'
   
   //maven35.pull()
      
   stage 'Build'

   maven35.inside() {

	   checkout scm
   	
   	 	withCredentials(
                [
                    [$class: 'StringBinding', credentialsId: 'M2_PWD', variable: 'M2_PWD']
                ]) {
 
			sh 'export'

			sh 'mvn -B -s jenkins-settings.xml clean install'

        }

   }
  
}
