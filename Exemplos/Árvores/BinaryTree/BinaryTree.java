
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        this.root = add(this.getRoot(), node);
    }

    private Node add(Node root, Node node) {
        // Caso base: inserir o nó
        if (root == null) {
            return node;
        }

        // Inserção recursiva
        if (node.getInfo() <= root.getInfo()) {
            root.setLeftNode(add(root.getLeftNode(), node));
        } else {
            root.setRightNode(add(root.getRightNode(), node));
        }

        // Balancear o nó atual
        return balanceTree(root, node);
    }

    private void showInOrder(Node node, int tabs) {
        if (node != null) {
            showInOrder(node.getLeftNode(), tabs+4);    
            for (int i=0; i < tabs; i++) 
            {
                System.out.append(" ");
            }
            // visita esquerda
            System.out.print(node.getInfo() + "\n"); // visita raiz
            showInOrder(node.getRightNode(),tabs + 4);    // visita direita
        }
    }

    // Método para iniciar a impressão
    public void show() {
        showInOrder(this.root, 2);
        System.out.println(); // só quebra linha
    }

    private boolean isExists(Node root, int key)
    {
        if (root == null)
        {
            return false;
        }

        System.out.println("Arvore posquisada: ");
        this.showInOrder(root, 1);

        if (root.getInfo() == key)
        {
            return true;
        }

        if (root.getInfo() >= key)
        {
            return isExists(root.getLeftNode(), key);
        }

        return isExists(root.getRightNode(), key);
    }

    public boolean found(int key)
    {
        return isExists(this.getRoot(), key);
    }

    private Node balanceTree(Node root, Node node) {
        if (root == null) {
            return null;
        }
        // Verifica o desequilíbrio e realiza as rotações necessárias
        int balanceFactor = height(root.getLeftNode()) - height(root.getRightNode());
        //"\nBalancedFactor: " << balanceFactor << " key: " << key << " root->key: " << root -> key << "\n\n";

        // desbalanceamento à esquerda
        if (balanceFactor > 1) {
            if (node.getInfo() <= root.getLeftNode().getInfo()) {
                root = rotateRight(root); // (LL)
            } else {
                root = rotateLeftRight(root); // (LR)
            }
        // desbalanceamento à direita
        } else if (balanceFactor < -1) {
            if (node.getInfo() > root.getRightNode().getInfo()) {
                root = rotateLeft(root); // (RR)
            } else {
                root = rotateRightLeft(root); // (RL)
            }
        }
        return root;
    }

// Função para realizar uma rotação simples para a esquerda (LL)
    private Node rotateLeft(Node root) {
        Node newRoot = root.getRightNode();
        root.setRightNode(newRoot.getLeftNode());
        newRoot.setLeftNode(root);
        return newRoot;
    }

// Função para realizar uma rotação simples para a direita (RR)
    private Node rotateRight(Node root) {
        Node newRoot = root.getLeftNode();
        root.setLeftNode(newRoot.getRightNode());
        newRoot.setRightNode(root);
        return newRoot;
    }

// Função para realizar uma rotação dupla à esquerda (LR)
    private Node rotateLeftRight(Node root) {
        root.setLeftNode(rotateLeft(root.getLeftNode()));
        return rotateRight(root);
    }

// Função para realizar uma rotação dupla à direita (RL)
    private Node rotateRightLeft(Node root) {
        root.setRightNode(rotateRight(root.getRightNode()));
        return rotateLeft(root);
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.getLeftNode()), height(root.getRightNode())) + 1;
    }

    // Remove por chave: atualiza a raiz da árvore
    public void remove(int key) {
        this.root = deleteNode(this.root, key);
    }

    /**
     * Remove 'key' a partir de 'root' e reequilibra como AVL.
     * Retorna a nova raiz da (sub)árvore.
     */
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null; // chave não encontrada
        }

        // Caminha como BST
        if (key < root.getInfo()) {
            root.setLeftNode(deleteNode(root.getLeftNode(), key));
        } else if (key > root.getInfo()) {
            root.setRightNode(deleteNode(root.getRightNode(), key));
        } else {
            // Encontrou o nó a remover
            if (root.getLeftNode() == null || root.getRightNode() == null) {
                // 0 ou 1 filho
                Node child = (root.getLeftNode() != null) ? root.getLeftNode() : root.getRightNode();
                root = child; // pode virar null (nó folha) ou o único filho
            } else {
                // 2 filhos: substitui pelo sucessor (menor da subárvore direita)
                Node succ = getMin(root.getRightNode());
                root.setInfo(succ.getInfo());
                root.setRightNode(deleteNode(root.getRightNode(), succ.getInfo()));
            }
        }

        // Se a (sub)árvore ficou vazia após remoção
        if (root == null) return null;

        // Reequilibra como AVL com base nas alturas dos filhos
        return rebalance(root);
    }

    /* ---------- Auxiliares específicos para remoção ---------- */

    // Menor nó (sucessor) de uma subárvore (assume n != null)
    private Node getMin(Node n) {
        while (n.getLeftNode() != null) {
            n = n.getLeftNode();
        }
        return n;
    }

    // Reequilibra o nó 'n' como AVL usando alturas dos filhos
    private Node rebalance(Node n) {
        int bf = height(n.getLeftNode()) - height(n.getRightNode());

        // Pesado à esquerda
        if (bf > 1) {
            // Se filho esquerdo é Right-heavy, faz rotação dupla (LR)
            if (height(n.getLeftNode().getRightNode()) > height(n.getLeftNode().getLeftNode())) {
                n.setLeftNode(rotateLeft(n.getLeftNode()));   // passo L
            }
            return rotateRight(n); // passo R (LL ou LR final)
        }

        // Pesado à direita
        if (bf < -1) {
            // Se filho direito é Left-heavy, faz rotação dupla (RL)
            if (height(n.getRightNode().getLeftNode()) > height(n.getRightNode().getRightNode())) {
                n.setRightNode(rotateRight(n.getRightNode())); // passo R
            }
            return rotateLeft(n); // passo L (RR ou RL final)
        }

        // Já balanceado
        return n;
    }

}

