package util;

import entity.ToDo;
import entity.ToDoInfos;
import entity.ToDoStatus;
import service.IToDoListService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;
    private String choice;
    private IToDoListService _toDoListService;

    public IHM(IToDoListService toDoListService) {
        scanner = new Scanner(System.in);
        _toDoListService = toDoListService;
    }

    public void start() {
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createToDo();
                    break;
                case "2":
                    showToDos();
                    break;
                case "3":
                    completeToDo();
                    break;
                case "4":
                    deleteToDo();
                    break;
            }
        } while (!choice.equals("0"));
        System.out.println("Merci d'avoir utilisé le service de gestion de ToDoList, au revoir");
    }

    private void menu() {
        System.out.println("## Menu Principal ##");
        System.out.println("1 - Ajouter une tâche à la liste");
        System.out.println("2 - Afficher toutes les tâches de la liste");
        System.out.println("3 - Marquer une tâche comme terminée");
        System.out.println("4 - Supprimer une tâche de la liste");
        System.out.println("0 - Quitter l'application");
        System.out.print("Choix : ");
    }

    private void createToDo() {
        System.out.print("Saisir le label de la ToDo : ");
        String todoLabel = scanner.nextLine();
        System.out.println("Choisir le status de la ToDo : ");
        statusMenu();
        choice = scanner.nextLine();
        ToDoStatus status;
        switch (choice) {
            case "2":
                status = ToDoStatus.COMPLETED;
                break;
            default:
                status = ToDoStatus.PENDING;
                break;
        }
        System.out.print("Saisir la description de la ToDo : ");
        String description = scanner.nextLine();
        System.out.print("Saisir l'échéance de la ToDo : ");
        String stringEcheance = scanner.nextLine();
        Date echeance = Date.valueOf(stringEcheance);
        System.out.println("Choisir la priorite de la ToDo :");
        prioriteMenu();
        choice = scanner.nextLine();
        Integer priorite;
        switch (choice){
            case "2":
                priorite = 2;
                break;
            case "3":
                priorite = 3;
                break;
            default:
                priorite = 1;
                break;
        }
        ToDoInfos newToDoInfos = _toDoListService.createAndSaveToDoInfos(description, echeance, priorite);
        if (newToDoInfos != null){
            ToDo newToDo = _toDoListService.createAndSaveToDo(todoLabel, status, newToDoInfos);
            if (newToDo != null) {
                System.out.println("La ToDO a correctement été crée avec l'id " + newToDo.getId());
            } else {
                System.out.println("Problème lors de la création de la ToDo");
            }
        }
        else {
            System.out.println("Problème lors de l'enregistrement des infos de la ToDo");
        }
    }

    private void statusMenu() {
        for (int i = 0; i < ToDoStatus.values().length; i++) {
            System.out.println(i + 1 + " - " + ToDoStatus.values()[i]);
        }
        System.out.print("Choix : ");
    }

    private void prioriteMenu(){
        System.out.println("1 - Faible");
        System.out.println("2 - Moyenne");
        System.out.println("3 - Urgente");
        System.out.print("Choix : ");
    }

    private void showToDos() {
        for (ToDo toDo : _toDoListService.readToDos()) {
            System.out.println(toDo);
        }
    }

    private void completeToDo() {
        List<ToDo> todos = _toDoListService.readToDos();
        for (ToDo toDo : todos) {
            if (toDo.getStatus() == ToDoStatus.PENDING) {
                System.out.println(toDo);
            }
        }
        System.out.print("Saisir l'id de la ToDo à finir : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        ToDo toDo = _toDoListService.readToDo(id);
        if (toDo != null) {
            toDo.setStatus(ToDoStatus.COMPLETED);
            if (_toDoListService.updateToDo(toDo)) {
                System.out.println("ToDo mise à jour");
            }
            else {
                System.out.println("Erreur dans la mise à jour de la todo");
            }
        } else {
            System.out.println("Aucune ToDo avec l'id : " + id);
        }
    }

    private void deleteToDo() {
        _toDoListService.readToDos().forEach(System.out::println);
        System.out.print("Saisir l'id de la ToDo à supprimer : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        if (_toDoListService.deleteToDo(id)){
            System.out.println("ToDo supprimée");
        }
        else {
            System.out.println("Erreur de la suppression de la ToDo");
        }

    }
}
