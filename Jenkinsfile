node {
  
   def maven35 = docker.image('jayv/jenkins-java');
   
   stage 'Pull build image'
   
   //maven35.pull()
      
   stage 'Build'

   maven35.inside() {
   	
   		sh 'export'
   	
	   	environment {
		   M2_PWD = credentials('M2_PWD')
		}
   	
   	   	sh 'export'
   	
	   checkout scm
       sh 'mvn -B -s jenkins-settings.xml clean install'
   }
  
}
