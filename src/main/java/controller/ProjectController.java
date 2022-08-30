/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author Carolina
 */
public class ProjectController {
    
    public void creat(Project project) {
        
        String sql = "INSERT INTO projects "
                + "(name, "
                + "description, "
                + "created_at, "
                + "updated_at) "
                + "VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));         
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar o "
                    + "projeto " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Project> list() {
        
        String sql = "SELECT * FROM projects";
         
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            
            Project project = new Project();
            
            project.setId(resultSet.getInt("id"));
            project.setName(resultSet.getString("name"));
            project.setDescription(resultSet.getString("description"));
            project.setCreatedAt(resultSet.getDate("created_at"));
                project.setUpdatedAt(resultSet.getDate("updated_at"));
                        
            projects.add(project);
        }            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar "
                    + "projeto(s) " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return projects;
    }
    
    public void edit(Project project) {
        
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "created_at = ?, "
                + "updated_at = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));     
            statement.setInt(5, project.getId());   
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao editar o "
                    + "projeto " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void delet(int projectId) {
        
        String sql = "DELET FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar "
                    + "projeto " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
