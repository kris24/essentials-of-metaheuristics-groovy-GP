package treeGP

import spock.lang.Specification
import treeGP.*

class NodeSpecification extends Specification {
    
    def 'test arity'() {
        when:
        Node add = new Node('+')
        Node sub = new Node('-')
        Node mul = new Node('*')
        Node divis = new Node('/')
        
        Node sin = new Node('sin')
        Node cos = new Node('cos')
        Node tan = new Node('tan')
        
        Node constant = new Node(5)
        then:
        
        add.arity == 2
        sub.arity == 2
        mul.arity == 2
        divis.arity == 2
        
        sin.arity == 1
        cos.arity == 1
        tan.arity == 1
        
        constant.arity == 0
    }
    
    def 'test addition'() {
        when:
        Node head = new Node('+')
        head.right = new Node(6)
        head.left = new Node(4)
        
        then:
        head.evaluate() == 10
    }

    def 'test subtraction'() {
        when:
        Node head = new Node('-')
        head.left = new Node(4)
        head.right = new Node(6)
        
        then:
        head.evaluate() == -2
    }

    def 'test multiplication'() {
        when:
        Node head = new Node('*')
        head.right = new Node(6)
        head.left = new Node(4)
        
        then:
        head.evaluate() == 24
    }
    
    def 'test division'() {
        when:
        Node head = new Node('/')
        head.left = new Node(6)
        head.right = new Node(2)
        
        
        then:
        head.evaluate() == 3
    }
    
    def 'test sin'() {
        when:
        Node head = new Node('sin')
        head.right = new Node(Math.PI)
        
        
        then:
        ((long)head.evaluate()) == 0
    }
    
    def 'test cos'() {
        when:
        Node head = new Node('cos')
        head.right = new Node(Math.PI)
        
        
        then:
        ((long)head.evaluate()) == -1
    }
    
    def 'test tan'() {
        when:
        Node head = new Node('tan')
        head.right = new Node(Math.PI)
        
        
        then:
        ((long)head.evaluate()) == 0
    }
    
    def 'multi operator'() {
        when:
        Node head = new Node ('+')
        Node d1l = new Node ('-')
        Node d1r = new Node ('*')
        Node d2l1 = new Node (5)
        Node d2r1 = new Node (2)
        Node d2l2 = new Node (4)
        Node d2r2 = new Node (4)
        
        head.left = d1l
        head.right = d1r
        d1l.left = d2l1
        d1l.right = d2r1
        d1r.left = d2l2
        d1r.right = d2r2
        
        then:
        head.evaluate() == 19
    }
}