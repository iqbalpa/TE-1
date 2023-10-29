# REFERENCES:
# https://www.geeksforgeeks.org/dual-pivot-quicksort/
def dualPivotQuickSort(arr, low, high): 
	if low < high: 
		# left pivot, right pivot
		lp, rp = partition(arr, low, high) 
		# recursively sort the subarrays
		dualPivotQuickSort(arr, low, lp - 1) 
		dualPivotQuickSort(arr, lp + 1, rp - 1) 
		dualPivotQuickSort(arr, rp + 1, high) 

def partition(arr, low, high): 
	if arr[low] > arr[high]: 
		arr[low], arr[high] = arr[high], arr[low] 
	# p is the left pivot, and q is the right pivot. 
	j = k = low + 1
	g, p, q = high - 1, arr[low], arr[high] 
	
	while k <= g: 
		# If elements are less than the left pivot 
		if arr[k] < p: 
			arr[k], arr[j] = arr[j], arr[k] 
			j += 1
		# If elements are greater than or equal than the right pivot 
		elif arr[k] >= q: 
			while arr[g] > q and k < g: 
				g -= 1
			arr[k], arr[g] = arr[g], arr[k] 
			g -= 1
			if arr[k] < p: 
				arr[k], arr[j] = arr[j], arr[k] 
				j += 1
		k += 1
	j -= 1
	g += 1
	
	# Bring pivots to their appropriate positions. 
	arr[low], arr[j] = arr[j], arr[low] 
	arr[high], arr[g] = arr[g], arr[high] 
	return j, g 


# Driver code 
if __name__ == '__main__':
	arr = [ 24, 8, 42, 75, 29, 77, 38, 57 ] 

	dualPivotQuickSort(arr, 0, 7) 

	print('Sorted array: ', end = '') 
	for i in arr: 
		print(i, end = ' ') 	
