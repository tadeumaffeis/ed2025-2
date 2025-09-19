// private BTreeNode<T> balanceTree(BTreeNode root, BTreeNode node) {
//         if (root == null) {
//             return null;
//         }
//         // Verifica o desequilíbrio e realiza as rotações necessárias
//         int balanceFactor = height(root.getLeftNode()) - height(root.getRightNode());
//         //"\nBalancedFactor: " << balanceFactor << " key: " << key << " root->key: " << root -> key << "\n\n";

//         // desbalanceamento à esquerda
//         if (balanceFactor > 1) {
//             if (node.getKey().compareTo(root.getLeftNode().getKey()) <= 0) {
//                 root = rotateRight(root);
//             } else {
//                 root = rotateLeftRight(root);
//             }
//         // desbalanceamento à direita
//         } else if (balanceFactor < -1) {
//             if (node.getKey().compareTo(root.getRightNode().getKey()) > 0) {
//                 root = rotateLeft(root);
//             } else {
//                 root = rotateRightLeft(root);
//             }
//         }

//         return root;
//     }

//     private int height(BTreeNode node) {
//         if (node == null) {
//             return 0;
//         }
//         return Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1;
//     }

//     private BTreeNode<T> rotateLeft(BTreeNode<T> node) {
//         BTreeNode<T> newRoot = node.getRightNode();
//         node.setRightNode(newRoot.getLeftNode());
//         newRoot.setLeftNode(node);
//         return newRoot;
//     }

// // Função para realizar uma rotação simples para a direita (RR)
//     private BTreeNode<T> rotateRight(BTreeNode<T> node) {
//         BTreeNode newRoot = node.getLeftNode();
//         node.setLeftNode(newRoot.getRightNode());
//         newRoot.setRightNode(node);
//         return newRoot;
//     }

// // Função para realizar uma rotação dupla à esquerda (LR)
//     private BTreeNode<T> rotateLeftRight(BTreeNode<T> node) {
//         node.setLeftNode(rotateLeft(node.getLeftNode()));
//         return rotateRight(node);
//     }

// // Função para realizar uma rotação dupla à direita (RL)
//     private BTreeNode<T> rotateRightLeft(BTreeNode<T> node) {
//         node.setRightNode(rotateRight(node.getRightNode()));
//         return rotateLeft(node);
//     }
