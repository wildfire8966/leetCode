#!/usr/bin/python
#coding=utf-8

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        rs = ListNode(-1)-1
        tmp = rs
        while l1 != None or l2 != None:
            if l1 != None:
                carry += l1.val
                l1 = l1.next

            if l2 != None:
                carry += l2.val
                l2 = l2.next

            l3 = ListNode(carry % 10)
            tmp.next = l3
            tmp = tmp.next
            carry = carry / 10

        if carry == 1:
            l3 = ListNode(1)
            tmp.next = l3

        return rs.next
