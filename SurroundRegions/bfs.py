#!/usr/bin/python
#coding=utf-8

class SurroundRegions(object):

	def __init__(self):
		self.dir = [(1,0),(-1,0),(0,1),(0,-1)]

	def slove(self, border):
		self.row_len = len(border)
		self.col_len = len(border[0])
		
		copy = [ [0] * self.col_len for x in range(self.row_len) ]

		for i in range(self.row_len):
			for j in range(self.col_len):
				# 元素是O且未被遍历过
				if copy[i][j] == 0 and border[i][j] == "O":
					self.checkSurround(border, copy, i, j)		

	def checkSurround(self, border, copy, x, y):
		#第一次遍历，确定是否有被包围的元素O
		q = []
		q.append((x,y))
		copy[x][y] = 1
		isSurround = True
		while len(q) != 0:
			curx, cury = q[0]
			q.remove(q[0])

			for i in range(4):
				tx = curx + self.dir[i][0]
				ty = cury + self.dir[i][1]
				
				# 相邻元素越界，表示该元素是边缘元素，则不存在包围情况
				if tx == -1 or tx == self.col_len or ty == -1 or ty == self.row_len:
					isSurround = False
					# 不返回的原因是：与其相邻的所有的O元素都要标为1
					# 表示这些元素已经被遍历且不属于被包围的O元素
					continue

				if border[tx][ty] == "O" and copy[tx][ty] == 0:
					q.append((tx, ty))
					copy[tx][ty] = 1

		if isSurround == False:
			return

		#若所有O元素未靠边，肯定被包围
		q = []
		q.append((x,y))
		copy[x][y] = 2
		while len(q) != 0:
			curx, cury = q[0]
			q.remove(q[0])
		
			border[curx][cury] = 'X'
	
			for i in range(4):
				tx = curx + self.dir[i][0]
				ty = cury + self.dir[i][1]

				if tx == -1 or tx == self.col_len or ty == -1 or ty == self.row_len:
					pass
				elif copy[tx][ty] == 1 and border[tx][ty] == "O":
					q.append((tx, ty))
					copy[tx][ty] = 2

	def print_border(self, border):
			for row in border:
				for col in row:
					print col + ' ',
				print

if __name__=="__main__":
	border = [
		['X','O','X','X','X'],
		['X','O','X','O','X'],
		['X','X','O','X','X'],
		['X','O','O','X','X'],
		['X','X','X','O','X']
	]
	sr = SurroundRegions()
	print 'Input:'
	sr.print_border(border)	
	sr.slove(border)
	print 'Output:'
	sr.print_border(border)
