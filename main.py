from data import save_data, load_data
import time
from mergesort import mergesort
from quicksort_2pivot import dualPivotQuickSort

# # generate data and save them into pickle
# save_data("dataset/2-9/random.ob", 2**9, "random")
# save_data("dataset/2-9/sorted.ob", 2**9, "sorted")
# save_data("dataset/2-9/reversed.ob", 2**9, "reversed")
# save_data("dataset/2-13/random.ob", 2**13, "random")
# save_data("dataset/2-13/sorted.ob", 2**13, "sorted")
# save_data("dataset/2-13/reversed.ob", 2**13, "reversed")
# save_data("dataset/2-16/random.ob", 2**16, "random")
# save_data("dataset/2-16/sorted.ob", 2**16, "sorted")
# save_data("dataset/2-16/reversed.ob", 2**16, "reversed")

# # load data
lst = load_data("dataset/2-9/random.ob")
# load_data("dataset/2-9/sorted.ob")
# load_data("dataset/2-9/reversed.ob")
# load_data("dataset/2-13/random.ob")
# load_data("dataset/2-13/sorted.ob")
# load_data("dataset/2-13/reversed.ob")
# load_data("dataset/2-16/random.ob")
# load_data("dataset/2-16/sorted.ob")
# load_data("dataset/2-16/reversed.ob")

# merge sort
start = time.time()
sorted_lst = mergesort(lst)
end = time.time()
print(f'Time taken: {end-start:.5f}s')

# quick sort 2 pivot
start = time.time()
sorted_lst = dualPivotQuickSort(lst, 0, len(lst)-1)
end = time.time()
print(f'Time taken: {end-start:.5f}s')
