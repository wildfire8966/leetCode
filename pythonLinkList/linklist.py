#!/usr/bin/python
#coding=utf-8
#author:yuanye

'''
链表的python实现，带头结点, 头节点存储元素-1
链表位置从1开始
'''

class Node(object):
	'''
	链表的数据元素节点
	'''
	def __init__(self, value):
		self.value = value
		self.next = None

class LinkList(object):
	'''
	链表结构
	'''
	def __init__(self):
		self.len = 0
		self.First = Node(-1)

	def get_len():
		return self.len

	def createBySeq(self, seq):
		for x in seq:
			self.append(x)
		return self.First

	def append(self,e):
		i = self.len
		if i == 0:
			self.First.next = Node(e) 
			self.len += 1
			return
		tmp = self.First.next
		for x in range(1,i):
			tmp = tmp.next
		tmp.next = Node(e)
		self.len += 1

	def NodeInsert(self, i, e):
		if i < 1 or i > self.len or self.len == 0:
			print "[ERROR] current len:", self.len, ", try to insert", e, "at position", i, "."
			return -1
		n = Node(e)
		if i == 1:
			tmp = self.First
		else:
			tmp = self.First.next
		for x in xrange(1,i - 1):
			print "asdasdasd"
			tmp = tmp.next
		n.next = tmp.next
		tmp.next = n
		self.len += 1

	def printList(self):
		if self.len == 0:
			print "list length is 0."
			return
		print self.First.value, " ",
		tmp = self.First.next
		while tmp != None:
			print tmp.value, " ",
			tmp = tmp.next
		print

data = [1,2,3]
l = LinkList()
l.createBySeq(data)
print "origin: ",; l.printList()
print "insert: ",; l.NodeInsert(2, 4)
l.printList()
print "insert: ",;l.NodeInsert(1, 5)
l.printList()
print "append: ",;l.append(0)
l.printList()
print "insert: ",;l.NodeInsert(7, 9)
print "insert: ",;l.NodeInsert(-1, 8)
