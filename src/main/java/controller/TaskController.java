/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Carolina
 */
public class TaskController {
    
    public void creat(Task task) {
        
        String sql = "INSERT INTO tasks "
                + "(name, "
                + "description, "
                + "situation, "
                + "note, "
                + "ends_at, "
                + "created_at, "
                + "updated_at, "
                + "id_project) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isSituation());
            statement.setString(4, task.getNote());
            statement.setDate(5, new Date(task.getEndsAt().getTime()));
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(8, task.getIdProject());          
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a "
                    + "tarefa " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
     public List<Task> list(int idProject) {
        
        String sql = "SELECT * FROM tasks WHERE id_project = ?";
         
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            
            Task task = new Task();
            task.setId(resultSet.getInt("id"));
            task.setName(resultSet.getString("name"));
            task.setDescription(resultSet.getString("description"));
            task.setSituation(resultSet.getBoolean("situation"));
            task.setNote(resultSet.getString("note"));
            task.setEndsAt(resultSet.getDate("ends_at"));
            task.setCreatedAt(resultSet.getDate("created_at"));
            task.setUpdatedAt(resultSet.getDate("updated_at"));
            task.setIdProject(resultSet.getInt("id_project"));
            
            tasks.add(task);
        }            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar "
                    + "tarefa(s) " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return tasks;
    }
    
    public void edit(Task task) {
        
        String sql = "UPDATE tasks SET "
                + "name = ?, "
                + "description = ?, "
                + "situation = ?, "
                + "note = ?, "
                + "ends_at = ?, "
                + "created_at = ?, "
                + "updated_at = ?, "
                + "id_project = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isSituation());
            statement.setString(4, task.getNote());
            statement.setDate(5, new Date(task.getEndsAt().getTime()));
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(8, task.getIdProject());     
            statement.setInt(9, task.getId());   
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao editar a "
                    + "tarefa " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void delet(int taskId) throws SQLException {
        
        String sql = "DELET FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar "
                    + "tarefa " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
   
    
}
