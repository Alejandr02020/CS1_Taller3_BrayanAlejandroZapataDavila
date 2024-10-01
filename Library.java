public class Library {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
        int option = menu.readOption();

        Administrator administrator = new Administrator(null, null, null, null, 0, 0, null, null, null, 0, 0);
        Student student = new Student(null, null, null, null, 0, 0, null, null, null, 0, 0);
        Teacher teacher = new Teacher(null, null, null, null, 0, 0,  null, null, null, 0, 0);
        while (option != 4) {
            if (option == 1) {
                menu.showStudentMenu();
                int studentOption = menu.readOption();

                while (studentOption != 4) {
                    if (studentOption == 1) {
                        student.reserveMaterial();

                    } else if (studentOption == 2) {
                        student.renewMaterial();

                    } else if (studentOption == 3) {
                        student.returnMaterial();

                    }

                    menu.showStudentMenu();
                    studentOption = menu.readOption();
                }

                if (studentOption == 4) {
                    menu.showMenu();
                    option = menu.readOption();
                }

            } else if (option == 2) {
                menu.showTeacherMenu();
                int teacherOption = menu.readOption();

                while (teacherOption != 4) {
                    if (teacherOption == 1) {
                        teacher.reserveMaterial();

                    } else if (teacherOption == 2) {
                        teacher.renewMaterial();

                    } else if (teacherOption == 3) {
                        teacher.returnMaterial();

                    }

                    menu.showTeacherMenu();
                    teacherOption = menu.readOption();
                }

                if (teacherOption == 4) {
                    menu.showMenu();
                    option = menu.readOption();
                }

            } else if (option == 3) {
                menu.showAdministrativeMenu();
                int administrativeOption = menu.readOption();

                while (administrativeOption != 7) {
                    if (administrativeOption == 1) {
                        administrator.registerPerson();

                    } else if (administrativeOption == 2) {
                        administrator.updatePerson();

                    } else if (administrativeOption == 3) {
                        administrator.deletePerson();

                    } else if (administrativeOption == 4) {
                        administrator.printInformation();

                    } else if (administrativeOption == 5) {
                        administrator.registerMaterial();

                    } else if (administrativeOption == 6) {
                        administrator.printMaterial();
                    }

                    menu.showAdministrativeMenu();
                    administrativeOption = menu.readOption();
                }

                if (administrativeOption == 7) {
                    menu.showMenu();
                    option = menu.readOption();
                }

            }
        }

        if (option == 4) {
            System.out.println("Gracias por usar la Biblioteca");
        }
    }
}