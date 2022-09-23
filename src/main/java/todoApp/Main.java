/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todoApp;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Carolina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
//--------------------------------
//        Cadastro teste de projeto
        ProjectController projectController = new ProjectController();
        Project project = new Project();
        project.setName("Teste n4");
        project.setDescription("descrição do teste n4");
        projectController.creat(project);
        
        
//--------------------------------
//        Edição teste de projeto
//        ProjectController projectController = new ProjectController();
//        Project project = new Project();
//        project.setId(2);
//        project.setName("Teste n2 - Edição");
//        project.setDescription("descrição do teste n2");
//        projectController.edit(project);

//--------------------------------
//        Consulta teste de projeto
//        ProjectController projectController = new ProjectController();
//        Project project = new Project();
//        List<Project> projects = projectController.getAll();
//        System.out.println("Total de projetos = " + projects.size());  

        
//--------------------------------
//        Cadastro teste de tarefa
//        TaskController taskController = new TaskController();
//        Task task = new Task();
//        task.setName("Teste n2");
//        task.setDescription("descrição do teste n2");
//        task.setNote("observação do teste n2");
//        task.setSituation(false);
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
//        Date date = format.parse("22/09/2022");
//        task.setEndsAt(date);
//        task.setIdProject(2);
//        taskController.creat(task);
        
        
//--------------------------------
//        Edição teste de tarefa
//        TaskController taskController = new TaskController();
//        Task task = new Task();
//        task.setName("Teste n1 - Edição");
//        task.setDescription("descrição do teste n1 - editada");
//        task.setNote("observação do teste n2 - edição");
//        task.setSituation(true);
//        task.setIdProject(1);
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
//        Date date = format.parse("10/10/2022");
//        task.setEndsAt(date);
//        task.setId(2);
//        taskController.edit(task);

//--------------------------------
//        Consulta teste de tarefa
//        TaskController taskController = new TaskController();
//        Task task = new Task();
//        List<Task> tasks = taskController.getAll(1);
//        System.out.println("Total de tarefas = " + tasks.size());  
        
    }
    
}
