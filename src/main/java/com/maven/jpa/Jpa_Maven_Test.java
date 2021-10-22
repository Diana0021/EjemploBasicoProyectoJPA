package com.maven.jpa;

import java.util.List;

import javax.persistence.*;

public class Jpa_Maven_Test {
//declaramos una variable de tipo entitymanager....
	private EntityManager manager;
	
	
	//creamos su respectivo constructor...
	public Jpa_Maven_Test(EntityManager manager) {
	//super();
	this.manager = manager;
	}//fin del constructor...



	public static void main(String[] args) {
		// aplicamos una variable de tipo entitymanagerfactory
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("Proyecto-Maven-Cibertec|||");
		// aplicamos una variable de tipo entitymanager
		EntityManager manager=factory.createEntityManager();
        //instanciamos la clase jpa-maven-test
        
        Jpa_Maven_Test jpamaven = new Jpa_Maven_Test(manager);
        //aplicamos  transacciones...
        EntityTransaction etran= manager.getTransaction();
        //iniciamos la transaction...
        etran.begin();
        //llamamos al metodo crear alumno..
        jpamaven.InsertarAlumno();
        //llamamos al metodo listar alumno
        //imprimimos los campos por consola....
        System.out.println("nombre" + "apellido"+ "sexo"+"email ");
        //declaramos una variable  de list para recuperar los valores de la BD..
        List<Alumno> listadoAlumn =jpamaven.ListarAlumnos();
        //aplicamos un bucle for....
        for(Alumno lisalum:listadoAlumn){
        	//imprimimos por consola...
        	System.out.println(lisalum.getNombre()+""+ lisalum.getApellido()
        	+""+lisalum.getDni()+""+lisalum.getSexo()+""+lisalum.getEmail());
        	
        }//fin del bucle for
        
        //llamamos al metodo actualizar alumno...
     jpamaven.ActualizarAlumnos(1,"Melany", "Chuquimbalqui", "40558899", "F", "melany@gmail.com");
	}//fin del metodo principal...
	
        public void InsertarAlumno(){
        	//instanciamos la clase alumno....
        	Alumno alumn= new Alumno("luis Enrique","Gomez","10554488","M","luis@gmail.com");
        	Alumno alumn2=new Alumno("Rosa Maria","Perez","40556688","F","rosa@gmail.com");
        	Alumno alumn3 = new Alumno("Arturo Jorge","Delgado","40334488","M","arturo@gmail.com");
            Alumno alumn4 = new Alumno("Ivan Javier","Ramirez","10556677","M","ivan@gmail.com");
            Alumno alumn5 = new Alumno("Carmen Rosa","Silva","40445533","F","carmen@gmail.com");
        //aplicamos el metodo de la persistencia
         manager.persist(alumn);
         manager.persist(alumn2);
         manager.persist(alumn3);
         manager.persist(alumn4);
         manager.persist(alumn5);
        }//fin del metodo insertar alumno


        // creamos el metodo  listar alumnos
        
        public List<Alumno> ListarAlumnos(){
        	//declaramos  una variable de tipo string 
        	String consulta="select a from Alumno a";
        	//aplicamos la interfaz query...
        	Query querycons= manager.createQuery(consulta,Alumno.class);
        	//almacenemos los valores de la BD en una variable de tipo List...
        	List<Alumno>listalum=querycons.getResultList();
        	//retornamos los valores
        	return listalum;
        }// fin del metodo listar alumnos
        
        //creamos el metodo actualizar alumnos
       public void  ActualizarAlumnos(int cod, String nom, String ape, String dn, String sex, String em){
        	
        	//declaramos variable de tipo string  para la consulta
        	String cons= "UPDATE Alumno a SET a.nombre=:nom,"
        			+ "a.apellido=:ape,a.dni=:dn,a.sexo=:sex,"
        			+ "a.email=:em where a.idalumno=:cod";
        	//aplicamos la interfaz Query
        	Query queryconsul=manager.createQuery(cons);
        	//aplicamos parametros dinamicos...
        	queryconsul.setParameter("cod",cod);
        	queryconsul.setParameter("nom",nom);
        	queryconsul.setParameter("ape",ape);
        	queryconsul.setParameter("dn",dn);
        	queryconsul.setParameter("sex",sex);
        	queryconsul.setParameter("em",em);
        	
        	//ejecutamos las instrucciones con el executeupdate...
        	int x=queryconsul.executeUpdate();
        	if(x>0)System.out.println("datos del alumno actualizados correctamente");
        }//fin del metodo actualizar alumnos
}//fin de la clase jpa_maven_test....
