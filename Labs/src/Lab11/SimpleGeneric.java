package Lab11;

public class SimpleGeneric<T> {

    private T ObjReff=null;

    public SimpleGeneric() {
    }

    public SimpleGeneric(T param) {
        ObjReff = param;
    }

    public void setObjReff(T obj) {
        this.ObjReff = obj;
    }

    public T getObjReff() {
        return ObjReff;
    }

    public void print() {
        System.out.println("Object: " + ObjReff);
    }

    public void printType() {
        System.out.println("Type: " + ObjReff.getClass().getName());

    }

}
