/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int maximumSize = 10000;
    Resume[] storage = new Resume[maximumSize];
    private int size = 0;

    protected void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    protected void save(Resume resume) {
        boolean is_exist = false;
        if (size != maximumSize) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString().equals(resume.toString())) {
                    System.out.println("Record with this uuid already exists");
                    is_exist = true;
                }
            }
            if (!is_exist) {
                storage[size] = resume;
                size++;
            }
        } else System.out.println("Array memory is full");
    }


    protected Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        System.out.println("Uuid not found");
        return null;
    }

    protected void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                index = i;
            }
            if (index != -1 && index <= i && index != size - 1) {
                storage[i] = storage[i + 1];
            }
        }
        if (index == -1) {
            System.out.println("Uuid not found");
        } else {
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    protected Resume[] getAll() {
        Resume[] arr = new Resume[size];
        System.arraycopy(storage, 0, arr, 0, size);
        return arr;
    }


    int size() {
        return size;
    }
}
