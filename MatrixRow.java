import com.sun.jdi.Value;

public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;

    public MatrixRow() {

    }


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        // case 1
        if(first == null) {
            first = value;
        }
        // case 2
        else if(value.getColumn() < first.getColumn()) {
            ValueNode temp = first;
            first = value;
            first.setNextColumn(temp);
        }
        else if(value.getColumn() > first.getColumn()) {
            ValueNode currentNode = first;
            while(currentNode.getNextColumn() != null) {
                int compare1 = currentNode.getColumn();
                int compare2 = currentNode.getNextColumn().getColumn();
                if(compare1 < value.getColumn() && compare2 > value.getColumn()) {
                    ValueNode temp = currentNode.getNextColumn();
                    currentNode.setNextColumn(value);
                    value.setNextColumn(temp);
                }
                if(currentNode.getNextColumn() != null) {
                    currentNode = currentNode.getNextColumn();
                }
            }
            if(currentNode.getColumn() < value.getColumn()) {
                currentNode.setNextColumn(value);
            }
        }
    }

    public int get(int position) {
        ValueNode current = first;
        for(int i = 1; i <= position; i++) {
            try {
                //System.out.println("get column: " + current.getColumn());
                if (current.getColumn() == position) {
                    return current.getValue();
                }
            }
            catch(Exception e) {
                return 0;
            }
            if(current.getNextColumn() != null) {
                current = current.getNextColumn();
            }
            //System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGg");
        }
        return 0;
    }
}



