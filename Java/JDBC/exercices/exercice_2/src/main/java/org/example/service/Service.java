package org.example.service;

import org.example.dao.ClientDAO;
import org.example.dao.CompteBancaireDAO;
import org.example.dao.OperationDAO;
import org.example.models.Client;
import org.example.models.CompteBancaire;
import org.example.models.Operation;
import org.example.models.OperationStatut;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Service {
    private ClientDAO clientDAO;
    private CompteBancaireDAO compteBancaireDAO;
    private OperationDAO operationDAO;

    private Connection connection;

    public Service() {
        try {
            connection = new DatabaseManager().getConnection();
            clientDAO = new ClientDAO(connection);

            compteBancaireDAO = new CompteBancaireDAO(connection);
            compteBancaireDAO.setClientDAO(clientDAO);

            operationDAO = new OperationDAO(connection);
            operationDAO.setCompteBancaireDAO(compteBancaireDAO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createClient(String nom,String prenom, String telephone){
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTelephone(telephone);
        try {
            return clientDAO.save(client);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateClient(Client client){
        try {
            return clientDAO.update(client);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client getClient(int id){
        try {
            return clientDAO.get(id);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteClient(int id){
        Client client = null;
        try {
            client = clientDAO.get(id);
            if(client != null){
                return clientDAO.delete(client);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Client> getAllClients(){
        try {
            return clientDAO.get();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCompteBancaire(Double solde, Client client){
        CompteBancaire compteBancaire = new CompteBancaire();
        compteBancaire.setSolde(solde);
        compteBancaire.setClient(client);
        try {
            return compteBancaireDAO.save(compteBancaire);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateCompteBancaire(CompteBancaire compteBancaire){
        try {
            return compteBancaireDAO.update(compteBancaire);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CompteBancaire getCompteBancaire(int id){
        try {
            return compteBancaireDAO.get(id);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletePerson(int id){
        CompteBancaire compteBancaire = null;
        try {
            compteBancaire = compteBancaireDAO.get(id);
            if(compteBancaire != null){
                return compteBancaireDAO.delete(compteBancaire);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<CompteBancaire> getAllCompteBancaire(){
        try {
            return compteBancaireDAO.get();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createOperation(double montant, String statut){
        Operation operation = new Operation();
        operation.setMontant(montant);
        operation.setStatut(OperationStatut.valueOf(statut));
        try {
            return operationDAO.save(operation);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateOperation(Operation operation){
        try {
            return operationDAO.update(operation);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Operation getOperation(int id){
        try {
            return operationDAO.get(id);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteOperation(int id){
        Operation operation = null;
        try {
            operation = operationDAO.get(id);
            if(operation != null){
                return operationDAO.delete(operation);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Operation> getAllOperations(){
        try {
            return operationDAO.get();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
