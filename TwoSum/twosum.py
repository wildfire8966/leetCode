#!/usr/bin/python
#coding=utf-8

class Solution(object):
	def twoSum(self, nums, target):
		"""
		:type nums: List[int]
		:type target: int
		:rtype: List[int]
		"""
		for x in nums:
			left = target - x
			if left in nums:
				try:
					if left == x:
						index_a = nums.index(x)
						index_b = nums.index(x, index_a + 1)
						return [index_a, index_b]
				except:
					continue
				return [nums.index(x),nums.index(left)]

a = [3,2,4,3]
print Solution().twoSum(a, 6)
