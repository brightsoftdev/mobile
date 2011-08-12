//
//  Category.m
//  Nellodee
//
//  Created by Ada Hopper on 09/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "Category.h"


@implementation Category
@synthesize title, tag, subcategories;

- (void)dealloc {
	[title release];
	[tag release];
	[subcategories release];
	[super dealloc];
}

@end
