# REFERENCES: 
# https://www.freecodecamp.org/news/how-to-sort-recursively-in-python/
# https://gist.github.com/samueltcsantos/5a9b4bea815d968c4b32
def mergesort(my_list):
	# Base Case
    if len(my_list) <= 1:
        return my_list
    # middle index of the list
    mid = len(my_list) // 2
    # Recursive Case
    left = mergesort(my_list[:mid])
    right = mergesort(my_list[mid:])
    # Sorting and merging two sorted list
    sort_list = merge(left, right)
    return sort_list

# Function to sort and merge 2 sorted lists
def merge(left, right):
    result = []
    i = 0
    j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    while i < len(left):
        result.append(left[i])
        i = i + 1
    while j < len(right):
        result.append(right[j])
        j = j + 1
    return result


# Driver Code
if __name__ == "__main__":
    my_list = [3, 8, 2, 7, 1, 4, 5]
    ans = mergesort(my_list)
    print(ans)