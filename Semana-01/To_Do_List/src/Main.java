import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            ShowMenu();
            System.out.print("Escolha uma opção: ");

            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    AddTask();
                    break;
                case 2:
                    ShowTasks();
                    break;
                case 3:
                    EditTask();
                    break;
                case 4:
                    RemoveTask();
                    break;
                case 5:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (option != 5);

        input.close();
    }

    public static void ShowMenu() {
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Cadastrar Tarefa");
        System.out.println("2 - Exibir Tarefas");
        System.out.println("3 - Editar Tarefa");
        System.out.println("4 - Remover Tarefa");
        System.out.println("5 - Sair");
    }

    public static void AddTask() {
        System.out.println("Digite a tarefa: ");
        String description = input.nextLine();
        Task task = new Task(description, nextId++);
        tasks.add(task);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    public static void ShowTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada");
        } else {
            System.out.println("Lista de Tarefas");
            for (Task task : tasks) {
                System.out.println("ID: " + task.getId() + " - " + task.getDescription());
            }
        }
    }

    public static void EditTask() {
        System.out.print("Digite o ID da tarefa a ser editada: ");
        int id = input.nextInt();
        input.nextLine(); //

        Task taskToEdit = findTaskById(id);
        if (taskToEdit != null) {
            System.out.print("Digite a nova tarefa: ");
            String newDescription = input.nextLine();
            taskToEdit.setDescription(newDescription);
            System.out.println("Tarefa editada com sucesso");
        } else {
            System.out.println("Tarefa não encontrada");
        }
    }

    public static void RemoveTask() {
        System.out.print("Digite o ID da tarefa que vai ser removida:");
        int id = input.nextInt();
        input.nextLine();

        Task taskToRemove = findTaskById(id);
        if (taskToRemove == null) {
            System.out.println("Tarefa não encontrada");
        } else {
            tasks.remove(taskToRemove);
            System.out.println("Tarefa removida com sucesso");
        }
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
