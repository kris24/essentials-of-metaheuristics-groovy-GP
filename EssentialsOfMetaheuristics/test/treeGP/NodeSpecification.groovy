package treeGP

import spock.lang.Specification
import treeGP.*

class NodeSpecification extends Specification {
	def setupSpec() {
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
		
		
	}
	
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
    
    def 'test a larger tree'() {
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
	
	def 'test toString'() {
		
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
		
		Node head2 = new Node('/')
		Node l = new Node('sin')
		Node r = new Node('cos')
		Node lv = new Node(Math.PI)
		Node rv = new Node(Math.PI)
		head2.left = l
		head2.right = r
		l.right = lv
		r.right = rv
		
		then:
		head.toString() == "((5 - 2) + (4 * 4))"
		head2.toString() == "(sin(3.141592653589793) / cos(3.141592653589793))"
		
	}
	
	def 'test cloning'() {
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
		
		Node head2 = head.clone()
		
		then:
		head != head2
		head.toString() == head2.toString()
		head.evaluate() == head2.evaluate()
	}
}